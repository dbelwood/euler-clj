(ns euler.utils)

;; Good sequences to have
(def odd-seq
  (iterate (partial + 2) 1))

(def fib-seq
  ((fn rfib [a b]
     (lazy-seq (cons a (rfib b (+ a b)))))
   0 1))

(def prime-seq
  (let [odd-seq (iterate (partial + 2) 3)
        prime? (fn [n]
                 (every?
                  #(not (zero? (mod n %)))
                  (take-while #(< (* % %) (inc n)) odd-seq)))]
          (cons 2
                (filter prime?
                        odd-seq))))

;; Mathematical algorithms
(defn gcd [a b]
  (if (> b a)
    (gcd b a)
    (let [a (rem a b)]
      (loop [a a b b]
        (let [r (rem a b)]
          (if (zero? r)
            b
            (recur b r)))))))

;; Useful transformers
(defn char->int [x] (- (int x) 48))
