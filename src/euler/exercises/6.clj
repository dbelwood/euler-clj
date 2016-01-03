(ns euler.exercises.6)

(let [rng (range 1 (inc 100))
      sum-of-squares (reduce + (map #(* % %) rng))
      square-of-sums (int (Math/pow (reduce + rng) 2))]
  (- (int (Math/pow (reduce + rng) 2))
     (reduce + (map #(* % %) rng))))
