(ns peek.scratch
  "A sandbox for throwing around the toys."
  (:require
   [sicmutils.env :refer [+ - * /]]
   [sicmutils.expression :as x]
   [sicmutils.value :as v]
   [sicmutils.structure :as struc]
   [pattern.rule :as rule :refer [=>]]
   [peek.light.classical.field-electric :as field-E]
   [peek.quantum.state :as state]
   [sicmutils.generic :as gen])

  (:import [sicmutils.structure Structure]))

(def quantum-ruleset
  (let []
    (rule/ruleset
     (*  (? ?a v/scalar?) (+ (? ?state1 v/scalar?) (? ?state2 v/scalar?)))
     =>
     (+ (* ?a ?state1) (* ?a ?state2))
     ;; --^ This expression shouldn't simplify?
     ;; -- The up-vector is not a scalar!
     (*  (? ?a v/scalar?) (+ (? ?state1 #(not (struc/up? %)))
                             (? ?state2 #(not (struc/up? %)))))
     false
     (+ (* ?a ?state1) (* ?a ?state2)))))

     ;; (* (+ (? ?a1 v/scalar?) (? ?a2 v/scalar?)) ?state1) => (+ (* ?a1 ?state1) (* ?a2 ?state1))


(comment
  (let [rs quantum-ruleset
        s (rule/rule-simplifier rs)

        psi1 (state/ket "1")
        psi2 (state/ket "2")]

    (v/scalar? psi1)
    ;; (v/scalar? 5.0)
    (s '(* 5.0 (+ (Structure. ::abstract-up [1] {}) (Structure. ::abstract-up [2] {}))))))

(comment
  (* (state/bra 1 0) (state/ket 1 0)))

(comment
  "- How do i declare that random symbols are actually 'things' i.e. scalars etc?
- Should I use the deftype system to define states?
-- Does this affect macros and the like? ")


(derive ::abstract-up ::struc/up)

(defmethod gen/mul [::abstract-up ::abstract-up] [a b] '(* a b))
(defmethod gen/add [::abstract-up ::abstract-up] [a b] `(~'+ ~a ~b))

(defmethod gen/add [::abstract-down ::struc/abstract-down] [a b] '(+ a b))
(defmethod gen/mul [::abstract-down ::struc/abstract-down] [a b] '(* a b))

(Structure. ::abstract-up [1] {})

(+ (Structure. ::struc/up [1] {}) (Structure. ::struc/up [2] {}))

(= '(+ a b) '(+ b a))

(let [foo [1 2 3]]
  `())
