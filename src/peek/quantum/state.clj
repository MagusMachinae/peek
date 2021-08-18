(ns peek.quantum.state
  (:require
   [peek.general.operator :as op]
   [sicmutils.generic :as gen]
   [sicmutils.complex :as com]
   [sicmutils.structure :as struc :refer [up down]]
   [sicmutils.value :as value]
   [sicmutils.env :as e]))

(derive ::ket ::up)

;; (defn state? [coll]
;;   "This is a fast, naive way of checking if the argument is a state.
;; FIXME: It also doesn't work... :(."
;;   (do (println (type  coll))
;;       (when (coll? coll)
;;         (do (println "got here")
;;             (and (contains? coll :label)
;;                  (contains? coll :state)
;;                  (or (= (:type coll) :ket)
;;                      (= (:type coll) :bra)))))))

;; (defn ket
;;   "Represents a quantum state vector. Is similar to 'up' within the SICM system.
;;   TODO: add a contsrutor that takes a bra. Probably using multi-methods?"
;;   ([label]
;;    {:label label
;;     :state (up nil)
;;     :type :ket})

;;   ([label values]
;;    {:label label
;;     :state (apply struc/up values)}))

;; (defn bra
;;   "TODO: Check corner cases and include type."
;;   ([label]
;;    (op/adjoint (ket label)))
;;   ([label values]
;;    (gen/transpose (ket label  values))))

(defn state? [x]
  (struc/structure? x))

(defn ket
  "A (temporary?) implementation of ket using meta-data."
  [labels]
  (with-meta (up) {:labels labels
                   :quantum-state :ket}))
(defn bra
  "A (temporary?) implementation of ket using meta-data."
  [labels]
  (with-meta (down) {:labels labels
                     :quantum-state :bra}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;             Play area...            ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
