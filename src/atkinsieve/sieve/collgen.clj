(ns
  atkinsieve.sieve.collgen)

 ;Had this is sieve.sieve but there was cyclic dependency error bec. is needed in wheels.wheels
(defn gen-coll "make the collection, a boolean vector w/ first two elems true" [lim]
  (apply vector (cons true (cons true (cons true (take (- lim 3) (repeat false)))))))

(defn rand-int-vec [n lim] (apply vector (take n (repeatedly #(rand-int lim)))))
