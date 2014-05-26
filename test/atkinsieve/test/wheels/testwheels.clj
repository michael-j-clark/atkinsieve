(ns
  atkinsieve.test.wheels.testwheels
  (:use clojure.test )
  (:use atkinsieve.wheels.wheels)
  (:use atkinsieve.sieve.collgen))

(def lim 20)
(def coll (gen-coll lim))

(def w1  (->WheelOne lim))
(def w2  (->WheelTwo lim))
(def w3  (->WheelThree lim))


(deftest wheel-one-calculate-test
  (let [v1 (rand-int-vec 5 lim) v2 [4 5988 6 123 4323]]
    (is (= (map #(+ (* 4 (* %1 %1)) (* %2 %2)) v1 v2) 
           (map #(calculate w1 %1 %2) v1 v2)))))
		 
(deftest wheel-one-tst-test
  (let [v1 [143 200 3 234 542235 45 12 86 77]] 
    (is (= (map #(and  (<= % lim) 
	               (or (= (mod %1 12) 1) (= (mod %1 12) 5))) v1) 
           (map #(tst w1 %1 ) v1)))))

(deftest wheel-two-calculate-test
  (let [v1 [143 2 3] v2 [4 5988 6]]
    (is (= (map #(+ (* 3 (* %1 %1)) (* %2 %2) ) v1 v2)
          (map #(calculate w2 %1 %2) v1 v2)))))

(deftest wheel-two-tst-test
  (let [v1 [143 200 3 234 542235 45 12 86 77]]
    (is (= (map #(and  (<= % lim)
                    (= (mod %1 12) 7)) v1)
          (map #(tst w2 %1 ) v1)))))

;todo: There is a problem now.  When (x<=y), n = (inc lim). This test does not reflect that.
;(deftest wheel-three-calculate-test
;  (let [v1 [143 2 3 32 234 123 1] v2 [4 5988 6 234  345 876 (+ (* 12 5) 11)]]
;    (is (= (map #(- (* 3 (* %1 %1)) (* %2 %2) ) v1 v2)
;          (map #(calculate w3 %1 %2) v1 v2)))))

(deftest wheel-three-tst-test
  (let [v1 [66143 200 8676743 542235 45 987 86 98098]]
    (is (= (map #(and (<= % lim)
                   (= (mod %1 12) 11)) v1))
          (map #(tst w3 %1 ) v1))))

(run-all-tests)
