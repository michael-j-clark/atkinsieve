(ns
  atkinsieve.test.math.mathfns
  (:use clojure.test )
  (:use atkinsieve.math.mathfns)

  )

(deftest squares-test
  (is (= (map #(*  % %) (range 10)) (map square (range 10)))))

(deftest multiply-test
  (let [q 32289 r 5]
    (is (= (map #(multiply % q) (range r)) (map #(* % q) (range r))))) )

(deftest plus-test
  (let [q 1763129 r 5]
    (is (= (map #(plus % q) (range r)) (map #(+ % q) (range r))))) )

(run-all-tests)