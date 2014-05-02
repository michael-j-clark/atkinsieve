(ns
  atkinsieve.sieve.sieve
  (:use [atkinsieve.wheels.wheels] )
  )


(defn first-sieve
  "do quadratic ~wheel factorizations~"
  [x y lim coll]
  (if (and (>= x (dec (Math/sqrt lim))) (>= y (dec (Math/sqrt lim))))
    coll
    (do
      (if (>= y (dec (Math/sqrt lim)))
        (let [w1 (->WheelOne lim coll)]
          (recur (inc x) 1 lim ((factor w1 x y)))
          (recur x (inc y) lim ((factor w1 x y))))))))



(defn sieve-of-atkin
  "optimized Sieve of Eratosthenes"
  [lim]
  (binding [coll (get-coll lim)]
    (first-sieve 1 1 lim coll)))


(defn -main "main function"
  [& args]
  (sieve-of-atkin (read-string (first args))))