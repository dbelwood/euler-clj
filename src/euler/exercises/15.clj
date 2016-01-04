(ns euler.exercises.15)

(letfn [(factorial [n]
          (apply *' (range 1 (inc n))))]
  (let [side-length 20]
    (/
     (factorial (* 2 side-length))
     (*'
      (factorial side-length)
      (factorial side-length)))))
