(ns peek.quantum.state
  (:require
   [peek.general.operator :as op]
   [sicmutils.generic :as gen]
   [sicmutils.complex :as com]
   [sicmutils.structure :as struc :refer [up]]
   [sicmutils.env :as e]))

(derive ::ket ::up)

(defn ket
  "Represents a quantum state vector. Is similar to 'up' within the SICM system.
  TODO: add a contsrutor that takes a bra. Probably using multi-methods?"
  ([label]
   {:label label
    :state (up nil)})

  ([label values]
   {:label label
    :state (apply struc/up values)}))

(defn bra
  ([label]
   (op/adjoint (ket label)))
  ([label values]
   (gen/transpose (ket label  values))))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;             Play area...            ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
