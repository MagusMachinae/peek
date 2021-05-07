(ns peek.general.operator
  (:require [sicmutils.generic :as gen]))

(defn adjoint [operator]
  "Operator could be a normal operator or a state vector (bra,ket etc.)."
  ((comp gen/conjugate gen/transpose) operator))
