(ns
  atkinsieve.sieve.sieve
  (:use atkinsieve.wheels.wheels)
  (:use atkinsieve.sieve.collgen))


(defn first-sieve
  "do quadratic ~wheel factorizations~"
  [x y w lim]
  ;todo: need some other control flow here like a loop.recur
  (loop  [x x y y coll (gen-coll lim)]
    (if (and (>= x (dec (Math/sqrt lim))) (>= y (dec (Math/sqrt lim))))
      coll
      (do
        (prn x y)
        (if (>= y (dec (Math/sqrt lim)))
          (recur (inc x) 1  (factor w x y coll))
          (recur x (inc y)  (factor w x y coll)))))))



(defn sieve-of-atkin
  "optimized Sieve of Eratosthenes"
  [lim]
  (let [w1 (->WheelOne lim)]
    (first-sieve 1 1 w1 lim)))


(defn -main "main function"
  [& args]
  (prn (sieve-of-atkin 20)));read-string (first args)))))