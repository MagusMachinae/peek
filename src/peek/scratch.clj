(ns peek.scratch
  "A sandbox for throwing around the toys."

  [:require
   [sicmutils.env :refer [+ - * /]]
   [sicmutils.expression :as x]
   [sicmutils.value :as v]
   [pattern.rule :as rule :refer [=>]]
   [peek.light.classical.field-electric :as field-E]
   [peek.quantum.state :as state]
   [sicmutils.generic :as gen]])

(def quantum-ruleset
  (let []
    (rule/ruleset
     (*  (? ?a v/scalar?) (+ ?state1 ?state2))
     =>
     (+ (* ?a ?state1) (* ?a ?state2)))))

(let [rs quantum-ruleset
      s (rule/rule-simplifier rs)

      psi1 (state/ket "1")
      psi2 (state/ket "2")]

  (println (s '(* 5.0 (+ psi1 psi2)))))
