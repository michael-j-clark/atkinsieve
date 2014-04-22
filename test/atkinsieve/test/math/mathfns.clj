(ns
  atkinsieve.test.math.mathfns
  (:use clojure.test )
  (:use atkinsieve.math.mathfns)
  )

(deftest squares-test
  (is (= (map #(*  % %) (range 10)) (map square (range 10)))))

(deftest multiply-test
  (is (= (map #(multiply % 7639) (range 5)) (map #(* % 7639) (range 5)))))

(deftest plus-test
  (is (= (map #(plus % 1763129) (range 5)) (map #(+ % 1763129) (range 5)))))

(run-all-tests)