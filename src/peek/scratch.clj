(ns peek.scratch
  "A sandbox for throwing around the toys."

  [:require [sicmutils.env :refer :all]
   [peek.light.classical.field-electric :as field-E]
   [sicmutils.generic :as gen]])

(println
 (->> (field-E/electric)
      simplify
      ->infix))
