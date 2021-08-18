(ns peek.quantum.state-test
  (:require [clojure.test :refer [deftest are is testing]]
            [peek.quantum.state :as state]
            [peek.general.operator :as op]
            [sicmutils.env :as s :refer [+ *]]))

(deftest ket-tests
  "TODO: auto-generate wider ranging tests (using spec?)"
  (let [scalar1 1.0
        scalar2 2.0
        state1 (state/ket (str scalar1))
        state2 (state/ket (str scalar2))
        state3 (state/ket "psi")]
    (testing "Linear combinations"
      (are [lhs rhs]
           (= lhs rhs)
        (* scalar1 (+ state1 state2)) (+ (* scalar1 state1) (* scalar1 state2))
        (* (+ scalar1 scalar2) state1) (+ (* scalar1 state1) (* scalar2 state1))
        (* scalar1 (* scalar2 state1)) (* (* scalar1 scalar2) state1)))
    (testing "products"
      (are [lhs rhs]
           (= lhs rhs)
        (* state1 (+ state2 state3)) (+ (* state1 state2) (* state1 state3))))))

(deftest bra-tests
  "TODO: auto-generate wider ranging tests (using spec?)"
  (let [scalar1 1.0
        scalar2 2.0
        state1 (state/bra (str scalar1))
        state2 (state/bra (str scalar2))
        state3 (state/bra "psi")]
    (testing "Linear combinations"
      (are [lhs rhs]
           (= lhs rhs)
        (* scalar1 (+ state1 state2)) (+ (* scalar1 state1) (* scalar1 state2))
        (* (+ scalar1 scalar2) state1) (+ (* scalar1 state1) (* scalar2 state1))
        (* scalar1 (* scalar2 state1)) (* (* scalar1 scalar2) state1)))
    (testing "products"
      (are [lhs rhs]
           (= lhs rhs)
        (* state1 (+ state2 state3)) (+ (* state1 state2) (* state1 state3))))))

(comment (* (state/bra "1") (state/ket "1")))
