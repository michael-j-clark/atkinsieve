(ns
  atkinsieve.sieve.sieve
  (:use atkinsieve.wheels.wheels)
  (:use atkinsieve.sieve.collgen)
  (:require [clojure.core.typed :refer [ann AnyInteger Seq check-ns]]))


(defn- first-sieve
  "do quadratic ~wheel factorizations~"
  [x y w lim]
  (loop  [x x y y coll (gen-coll lim)]
    (if (and (>= x (dec (Math/sqrt lim))) (>= y  (-> lim (Math/sqrt) (dec))))
      coll
      (if (>= y (dec (Math/sqrt lim)))
        (recur (inc x) 1  (factor w x y coll))
        (recur x (inc y)  (factor w x y coll))))))

(ann sieve-of-atkin [AnyInteger -> Seq])
(defn sieve-of-atkin
  "optimized Sieve of Eratosthenes"
  [lim]
  (let [w1 (->WheelOne lim)]
    (first-sieve 1 1 w1 lim)))

(comment
  @param [args] seq (clojure.lang.ArraySeq) to -main
  @return first arg from args
  @throws ClassCastException thrown if NaN)
(defn first-arg [args]
  (-> args (first) (read-string)))



