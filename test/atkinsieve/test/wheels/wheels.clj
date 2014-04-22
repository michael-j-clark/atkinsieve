(ns
  atkinsieve.test.wheels.wheels
  (:use clojure.test )
  (:use atkinsieve.wheels.wheels)
  )

(deftest test-test (is (= 1 1)))

(deftest wheel-one-test
  (def w1  (->WheelOne 20))
  (is (= 80 (calculate w1 2 8))))

(run-all-tests)