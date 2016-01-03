(ns euler.exercises.1)

(reduce
 +
 (filter
  (partial > 1000)
  (filter
   #(or (= (rem % 3) 0) (= (rem % 5) 0))
   (range 1 1001))))
