(ns euler.exercises.3)

(defn factors [x]
  (filter #(zero? (rem x %)) (range 2 (inc (Math/sqrt x)))))

(defn prime-factors [x]
  (filter #(zero? (count (factors %))) (factors x)))

(def goal 600851475143)
(apply max (prime-factors goal))
