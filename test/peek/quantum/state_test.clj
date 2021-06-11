(ns peek.quantum.state-test
  (:require [clojure.test :refer [deftest is testing]]
            [peek.quantum.state :as sut]
            [peek.general.operator :as op]
            [sicmutils.env :as s :refer [+ *]]))

(deftest ket-tests
  "TODO: auto-generate wider ranging tests (using spec?)"
  (let [scalar1 1.0
        scalar2 2.0
        state1 (ket (str scalar1))
        state2 (ket (str scalar2))
        state3 (ket "psi")]
    (testing "Linear combinations"
      (is
       (= (* scalar1 (+ state1 state2))
          (+ (* scalar1 state1) (* scalar1 state2)))
       (= (* (+ scalar1 scalar2) state1)
          (+ (* scalar1 state1) (* scalar2 state1)))
       (= (* scalar1 (* scalar2 state1))
          (* (* scalar1 scalar2) state1))))
    (testing "products"
      (= (* state1 (+ state2 state3))
         (+ (* state1 state2) (* state1 state3))))))

(comment (= (sut/ket) (op/adjoint (sut/bra))))
