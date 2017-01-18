(ns phone-number)

(defn number [n]
  (let [number (apply str (re-seq #"\d" n))]
  (cond
    (= 10 (count number))
        number
    (and (= 11 (count number)) (= \1 (first number)))
        (subs number 1)
    :else
        "0000000000")))

(defn area-code [n]
    (subs (number n) 0 3))

(defn pretty-print [n]
    (let [numb (number n)]
        (format "(%s) %s-%s" (subs numb 0 3) (subs numb 3 6) (subs numb 6))))

