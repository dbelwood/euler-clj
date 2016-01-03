(ns euler.exercises.5
  (:require [euler.utils :as utils]))

(letfn [(prime-factors [n]
          (let [inclusive-primes (take-while (partial >= n) utils/prime-seq)
                first-divisable-prime (first (filter #(zero? (rem n %)) inclusive-primes))]
            (if (nil? first-divisable-prime)
              ()
              (flatten
               (list
                first-divisable-prime
                (prime-factors (/ n first-divisable-prime)))))))
        (key-distrib [m [k v]]
          (if-not (contains? m k)
            (assoc m k (list v))
            (assoc m k (conj (get m k) v))))
        (max-count [[k vals]]
          [k (apply max vals)])
        (to-power [[k count]]
          (int (Math/pow k count)))]
  (let [freq-map (map #(frequencies (prime-factors %)) (range 1 (inc 20)))
        freq-seq (apply concat (remove nil? (map seq freq-map)))
        by-freqs-seq (reduce key-distrib {} freq-seq)
        by-highest-power-seq (map max-count by-freqs-seq)
        to-power-seq (map to-power by-highest-power-seq)]
    (reduce * to-power-seq)))
        
