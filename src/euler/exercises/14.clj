(ns euler.exercises.14)

(letfn [(collatz [n]
          (if (odd? n)
            (+ (* 3 n) 1)
            (/ n 2)))
        (collatz-chain [n]
          ((fn collatz-seq [x]
               (if (= x 1)
                 '(1)
                 (cons x (collatz-seq (collatz x)))))
           n))]
  (loop [s (range 0 1000000)
         n 0
         a 0
         m 0]
    (if (empty? s)
      a
      (let [c (count (collatz-chain (+ n 1)))]
        (if (> c m)
          (recur (drop 1 s) (+ n 1) (+ n 1) c)
          (recur (drop 1 s) (+ n 1) a m))))))
