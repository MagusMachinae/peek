(ns peek.general.state
  (:require
   [sicmutils.generic :as gen]
   [sicmutils.complex :as com]
   [sicmutils.structure :as struc]
   [sicmutils.env :as env]))

(derive ::ket ::struc/up)

(defn ket
  "Test"
  ([bra]
   {:label (:label bra)
    :vector ((comp gen/conjugate gen/transpose)
             (:vector bra))})

  ([label values]
   {:label label
    :vector (apply struc/up values)}))

(defn bra
  ([ket]
   {:label (:label ket)
    :vector ((comp gen/conjugate gen/transpose)
             (:vector ket))})
  ([label values]
   {:label label
    :vector
    (apply struc/down values)}))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;             Play area...            ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(comment
  (println
   ((comp gen/conjugate gen/transpose))))
