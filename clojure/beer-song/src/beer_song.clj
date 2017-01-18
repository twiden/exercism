(ns beer-song
    (:require [clojure.string :as s]))


(defn  first-line [n]
    (cond
        (= n 1)
            "1 bottle of beer on the wall, 1 bottle of beer.\n"
        (= n 0)
            "No more bottles of beer on the wall, no more bottles of beer.\n"
        :else
            (s/join [(str n) " bottles of beer on the wall, " (str n) " bottles of beer.\n"])
    )
)

(defn  second-line [n]
    (cond
        (= n 1)
            "Take it down and pass it around, no more bottles of beer on the wall.\n"
        (= n 0)
            "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
        :else
            (s/join ["Take one down and pass it around, " (str (- n 1)) " bottle" (if (> n 2) "s" "" )" of beer on the wall.\n"])
    )
)

(defn recursive-sing [from to]
    (loop [song [] current from stop to]
        (if (>= current stop)
            (recur
                (conj song (s/join [(first-line current) (second-line current)]))
                (dec current)
                stop
            )
            (s/join "\n" song)
        )
    )
)

(defn sing
    ([from, to] (recursive-sing from to))
    ([from] (sing from 0))
)

(defn verse [n]
  (sing n n)
)

