(ns
  atkinsieve.sieve.sieve
  (:use atkinsieve.wheels.wheels)
  (:use atkinsieve.sieve.collgen))


(defn first-sieve
  "do quadratic ~wheel factorizations~"
  [x y w lim]
  ;todo: need some other control flow here like a loop.recur
  (loop  [x x y y coll (factor w x y)]
    (if (and (>= x (dec (Math/sqrt lim))) (>= y (dec (Math/sqrt lim))))
      (factor w x y)
      (do
        (prn x y)
        (if (>= y (dec (Math/sqrt lim)))
          (recur (inc x) 1  (factor w x y))
          (recur x (inc y)  (factor w x y)))))))



(defn sieve-of-atkin
  "optimized Sieve of Eratosthenes"
  [lim]
  (let [coll (gen-coll lim) w1 (->WheelOne lim coll)]
    (first-sieve 1 1 w1 lim)))


(defn -main "main function"
  [& args]
  (prn (sieve-of-atkin 20)));read-string (first args)))))