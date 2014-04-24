(ns
  atkinsieve.wheels.wheels
  (:require [clojure.core.match :refer [match]])
  (:use [atkinsieve.math.mathfns]))



(defprotocol WheelFact
  (calculate [this x y])
  (tst [this n]))



(defrecord WheelOne
  [lim]
  WheelFact
  (calculate [this x y]  (plus (multiply 4 (square x)) (square y) ))
  (tst
    [this n]
    (true? (and (<= n lim) (or (n-mod-x-eq n 12 1)  (n-mod-x-eq n 12 5))))))



(defrecord WheelTwo
  [lim]
  WheelFact
  (calculate [this x y]  (plus (multiply 3 (square x)) (square y) ))
  (tst
    [this n]
    (true? (and (<= n lim) (n-mod-x-eq n 12 7)))))


(defrecord WheelThree
  [lim]
  WheelFact
  (calculate [this x y]  (minus (multiply 3 (square x)) (square y) ))
  (tst
    [this n]
    (true? (and (<= n lim) (n-mod-x-eq n 12 11) ))))

;todo (x>y) condition in wheel three test?
	


