(ns
  atkinsieve.sieve.sieve
  (:use atkinsieve.wheels.wheels)
  (:use atkinsieve.sieve.collgen)
  (:require [clojure.core.typed :refer [ann AnyInteger Seq check-ns]]))

(ann lte-lim?
  (All [x y]
    (Fn [AnyInteger  AnyInteger -> boolean]
        [AnyInteger  AnyInteger  AnyInteger -> boolean])))
(defn lte-lim?
  ;"where does comment go for arity-overloaded functions?"
  ([x lim]
  (if (>= x (-> lim (Math/sqrt) (dec)))
      true
      false))
  ([x y lim]
  (if (and (lte-lim? x lim) (lte-lim? y lim))
    true
    false)))

(defn- first-sieve
  "do quadratic ~wheel factorizations~"
  [wheel lim]
  (loop  [x 1 y 1 coll (gen-coll lim)]
    (if (and (lte-lim? x y lim))
      coll
      (if (lte-lim? y lim)
        (recur (inc x) 1  (factor wheel x y coll))
        (recur x (inc y)  (factor wheel x y coll))))))

(ann sieve-of-atkin [AnyInteger -> Seq])
(defn sieve-of-atkin
  "optimized Sieve of Eratosthenes"
  [lim]
  (let [w1 (->WheelOne lim)]
    (first-sieve w1 lim)))

(comment
  @param [args] seq (clojure.lang.ArraySeq) to -main
  @return first arg from args
  @throws ClassCastException thrown if NaN)
(defn first-arg [args]
  (-> args (first) (read-string)))



