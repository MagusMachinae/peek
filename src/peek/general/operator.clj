(ns peek.general.operator
  (:require [sicmutils.generic :as gen]))

;; (defn operator-abstract
;;   "A placeholder for a quantum operator.

;;   TODO: Can I use metadata to tell the simplifier things? - .e.g. Hermitian, symmetric etc.")

(defn adjoint [operator]
  "Operator could be a normal operator or a state vector (bra,ket etc.)."
  ((comp gen/conjugate gen/transpose) operator))
