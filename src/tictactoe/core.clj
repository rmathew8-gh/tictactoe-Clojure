(ns tictactoe.core
  (:gen-class))

;; (defn -main
;;   "I don't do a whole lot ... yet."
;;   [& args]
;;   (println "Tictactoe, World!"))

;; (defn factorial [x]
;;   (loop [i x]
;;     (if (> i 0)
;;       (do (print " " i)
;;           (recur (dec i))))))

(def board (vec (range 9)))
;; [0 1 2 3 4 5 6 7 8]

(def rows (vec (partition 3 board)))
;; [(0 1 2) (3 4 5) (6 7 8)]

(def cols [(take-nth 3 board)
           (take-nth 3 (subvec board 1))
           (take-nth 3 (subvec board 2))])
;; [(0 3 6) (1 4 7) (2 5 8)]

(defn all-3
  "returns true if all elems are the same"
  [elems]
  (apply = elems))

(def diag (take-nth 4 board))
(def ldiag (map (fn [a b] (nth b (- 2 a))) (range 3) rows))
;; diag: (0 4 8) ldiag: (2 4 6)

(defn play
  "replace an empty slot (denoted by a number) in the board"
  [board player]
  (let [board_ (remove #(contains? #{'x 'o} %) board)
        i (rand-nth board_)]
    (assoc board i player)))
;; (play [0 1 2 3 4 5 6 'y 8] 'y)

;; scratch pad.
(comment
  (let [elems ['x 'x 'x]]
    (apply = elems)))
