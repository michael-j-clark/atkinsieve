(ns
  ^{:author michaelclark}
  atkinsieve.wheels.wheels
  (:require [clojure.core.match :refer [match]]))
 ;TODO: require clojure.test
(use '[clojure.test :only [is]])


(defn square  [x]   (* x x))
(defn times   [x y] (* x y))
(defn plus    [x y] (+ x y))



(def ^:dynamic lim)
(defprotocol WheelFact
  (calculate [this x y])
  (test [this n]))



(defrecord WheelOne
  [lim]
  WheelFact
  (calculate [this x y]  (plus (times 4 (square x)) (square y) ))
  (test
    [this n]
    (is (true? (and (<= n lim) (or (== (mod n 12) 1)  (= (mod n 12) 5)))))))


; time to write some tests

;(def a (WheelOne. 20))

;(calculate a 2 7)








