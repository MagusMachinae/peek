(ns peek.light.classical.field-electric
  "A placeholder for convenience functions that create or operate on a classical electric field vector."
  (:require
   [clojure.string :as string]
   [sicmutils.generic :as gen :refer [* exp - +]]
   [sicmutils.complex :as com :refer [I]]
   [sicmutils.structure :as struc :refer [up down]]
   [sicmutils.env :refer [->TeX ->infix ->JavaScript simplify]]))

(def symbols-default
  {:time 't
   :field-amplitude 'E0
   :wave-number 'k
   :angular-frequency 'omega
   :phase 'phase})

(defn wave-product [k coordinates-spatial]
  "Creates a symbolic inner product of k and r, where k is the wavenumber symbol and r is a vector of symbols that represents the coordinate basis.


It would be nice to be able to represent this in a coordinate-free way!"
  (let [ksyms (mapv (comp symbol string/join)
                    (map reverse (into [] (zipmap  coordinates-spatial (repeat k)))))]
    (* (struc/down* ksyms) (struc/up* coordinates-spatial))))

(defn plane-wave
  "TODO: structureify the wavenumber multiplication."

  ([] (plane-wave 'x symbols-default))
  ([x symbols-default]
   (let [{:keys [time field-amplitude wave-number angular-frequency phase]} symbols-default]
     (* field-amplitude (exp
                         (+
                          (wave-product 'k ['x 'y 'z])
                          (* (- I) time angular-frequency)
                          phase))))))

(defn electric
  "A classical electric field (3-vector), where the components of the structure correspond to the polarisation in x,y,z (by default).

  []
  Returns an x-polarised planar wave with zero phase by default.

  [key]
  Returns a zero phase planar wave with the polarisation specified by the keyword.
  "
  ([]
   (up (plane-wave) 0 0))
  ([key]
   ;; (case key
   ;;   :LC
   ;;   :RC
   ;;   :pi)
   )
  ;; ([time field-amplitude angular-frequency phase]
  ;;  (up
  ;;   0
  ;;   0))
  )
