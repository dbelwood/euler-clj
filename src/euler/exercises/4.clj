(ns euler.exercises.4)

(def numbers (range 100 1000))

(def products
  (for [x numbers y numbers]
    (* x y)))

(defn reverse-number [number reversed]
  (if (zero? number)
    reversed
    (reverse-number (quot number 10) (+ (rem number 10) (* reversed 10)))))

(defn is-palindrome? [x]
  (= (reverse-number x 0) x))

(apply max (filter is-palindrome? products))
