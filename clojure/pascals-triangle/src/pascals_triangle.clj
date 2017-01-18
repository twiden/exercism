(ns pascals-triangle)

(defn next-row [prev]
    (map (fn [x] (+ (first x) (last x))) (partition 2 1 (concat [0] prev [0]))))

(def triangle
    (map first (iterate (fn [[a]] [(next-row a)]) [[(bigint 1)]])))

(defn row [r]
    (nth triangle (- r 1)))
