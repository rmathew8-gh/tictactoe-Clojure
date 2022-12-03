(ns tictactoe.core-test
  (:require
   [clojure.test :refer :all]
   [tictactoe.core :refer :all]))

(deftest test-basic-board
  (testing ""
    (is (= board [0 1 2 3 4 5 6 7 8]))))

(deftest test-rows
  (testing
   (is (= rows ['(0 1 2) '(3 4 5) '(6 7 8)]))))

(deftest test-cols
  (testing
   (is (= cols  ['(0 3 6) '(1 4 7) '(2 5 8)]))))

(deftest test-all-3
  (testing
   (do
     (is (= false (all-3 ['y 'x 'x])))
     (is (= true (all-3 ['x 'x 'x]))))))

(deftest test-play
  (testing
   (let [b (play board 'x)
         b (remove #(contains? #{'x 'o} %) b)]
        ;; there should be exactly 1 of #{'x 'o}
     (is (= (count b) 8)))))

(run-tests)
