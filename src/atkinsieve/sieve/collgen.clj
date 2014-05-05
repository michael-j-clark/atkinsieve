(ns
  atkinsieve.sieve.collgen)

 ;Had this is sieve.sieve but there was cyclic dependency error bec. is needed in wheels.wheels
(defn gen-coll "make the collection, a boolean vector w/ first two elems true" [lim]
  (apply vector (cons true (cons true (cons true (take (- lim 3) (repeat false)))))))

(defn rand-int-vec
  "generate vector of n random ints 'between 0 (inclusive) and n (exclusive).'"
  [n lim]
  {:pre (number? lim)}
  (into [] (take n (repeatedly #(rand-int lim)))))

