(ns myapp.exer01
  (:require [clojure.test :refer [deftest testing is]]))


(deftest test-1
  (testing "Example test"
    (is (= 3 3))))

;;; Ex 001 El
;; This is a clojure form. Enter a value which will make the form evaluate to true.
;; Don't over think it! If you are confused, see the getting started page.
;; Hint: true is equal to true.

(deftest test001
  (testing "Nothing but the Truth "
    (is (= true true))))


;;; Ex 002 El
;; If you are not familiar with polish notation, simple arithmetic might seem
;; confusing.
;; Note: Enter only enough to fill in the blank (in this case, a single number)
;; - do not retype the whole problem.

(deftest test002
  (testing "Simple Math"
    (is (= (- 10 (* 2 3)) 4))))


;;; Ex 003 El
;; Clojure strings are Java strings. This means that you can use any of the Java
;; string methods on Clojure strings.

(deftest test003
  (testing "Intro to Strings"
    (is (= "HELLO WORLD" (.toUpperCase "hello world")))))


;;; Ex 004 El
;; Lists can be constructed with either a function or a quoted form.

(deftest test004
  (testing "Intro to Lists"
    (is (= (list :a :b :c) '(:a :b :c)))))


;;; Ex 005 El
;;  When operating on a list, the conj function will return a new list with one
;; or more items "added" to the front.
;; Note that there are two test cases, but you are expected to supply only one
;; answer, which will cause all the tests to pass.

(def lst005 '(1 2 3 4))
(deftest test005
  (testing "Lists: conj"
    (is (= lst005 (conj '(2 3 4) 1)))
    (is (= lst005 (conj '(3 4) 2 1)))))


;;; Ex 006 El
;; Vectors can be constructed several ways. You can compare them with lists. 
;; Note: the brackets [] surrounding the blanks __ are part of the test case.

(deftest test006
  (testing "Intro to Vectors"
    (is (= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c)))))


;; Ex 007 El.
;; When operating on a Vector, the conj function will return a new vector with
;; one or more items "added" to the end.

(def vec007 [1 2 3 4])
(deftest test007
  (testing "Vectors: conj"
    (is (= vec007 (conj [1 2 3] 4)))
    (is (= vec007 (conj [1 2] 3 4)))))


;;; Ex 008 El.
;;  Sets are collections of unique values

(def set008 #{:a :b :c :d})
(deftest test008
  (testing "Intro to Sets"
    (is (= set008 (set '(:a :a :b :c :c :c :c :d :d))))
    (is (= set008 (clojure.set/union #{:a :b :c} #{:b :c :d})))))


;;; Ex 009 El.
;;  When operating on a set, the conj function returns a new set with
;;  one or more keys "added".

(def int009 2)
(deftest test009
  (testing "Sets: conj"
    (is (= #{1 2 3 4} (conj #{1 4 3} int009)))))


;;; Ex 010 El.
;;  Maps store key-value pairs. Both maps and keywords can be used as lookup
;;  functions. Commas can be used to make maps more readable, but they are not
;;  required.

(def int010 20)
(deftest test010
  (testing "Intro to Maps"
    (is (= int010 ((hash-map :a 10, :b 20, :c 30) :b)))
    (is (= int010 (:b {:a 10, :b 20, :c 30})))))


;;; Ex 011 El.
;;  When operating on a map, the conj function returns a new map with one or
;;  more key-value pairs "added".

(def vec011 [:b 2])
(deftest test011
  (testing "Maps: conj"
    (is (= {:a 1, :b 2, :c 3} (conj {:a 1} vec011 [:c 3])))))


;;; Ex 012 El.
;;  All Clojure collections support sequencing. You can operate on sequences
;;  with functions like first, second, and last.

(def in12 3)
(deftest test012
  (testing "Intro to Sequences"
    (is (= in12 (first '(3 2 1))))
    (is (= in12 (second [2 3 4])))
    (is (= in12 (last (list 1 2 3))))))


;;; Ex 013 El.
;;  The rest function will return all the items of a sequence except the first.

(deftest test013
  (testing "Sequences: rest"
    (is (= '(20 30 40)  (rest [10 20 30 40])))))


;;; Ex 014 El.
;;  Clojure has many different ways to create functions.

(deftest test14
  (testing "Intro to Fucctions"
    (is (= 8 ((fn add-five [x] (+ x 5)) 3)))
    (is (= 8 ((fn [x] (+ x 5)) 3)))
    (is (= 8 (#(+ % 5) 3)))))


;;; Ex 015 El.
;; Write a function which doubles a number.

(defn fn15 [num]
  (* 2 num))

(deftest test015
  (testing "Double down")
  (is (= (fn15 2) 4))
  (is (= (fn15 3) 6))
  (is (= (fn15 11) 22)))


;;; Ex 016 El.
;;  Write a function which returns a personalized greeting.

(defn fn16 [name]
  (str "Hello, " name "!"))

(deftest test016
  (testing "Hello World"
    (is (= (fn16 "Dave") "Hello, Dave!"))
    (is (= (fn16 "Jenn") "Hello, Jenn!"))
    (is (= (fn16 "Rhea") "Hello, Rhea!"))))


;;; Ex 017 El.
;; The map function takes two arguments: a function (f) and a sequence (s).
;; Map returns a new sequence consisting of the result of applying f to each
;; item of s. Do not confuse the map function with the map data structure.

(def lst17 '(6 7 8))

(deftest test017
  (testing "Sequences: map"
    (is (= lst17 (map #(+ % 5) '(1 2 3))))))


;;; Ex 018 El.
;;  The filter function takes two arguments: a predicate function (f) and a
;;  sequence (s). Filter returns a new sequence consisting of all the items
;;  of s for which (f item) returns true.

(def lst18 '(6 7))

(deftest test18
  (testing "Sequences: filter"
    (is (= lst18 (filter #(> % 5) '(3 4 5 6 7))))))


;;; Ex 035 El.
;;  Clojure lets you give local names to values using the special let-form.

(def num35 7)

(deftest test35
  (testing "Local bindings"
    (is (= num35 (let [x 5] (+ 2 x))))
    (is (= num35 (let [x 3, y 10] (- y x))))
    (is (= num35 (let [x 21] (let [y 3] (/ x y)))))))


;;; Ex 036 El.
;;  Can you bind x, y, and z so that these are all true?

(deftest test36
  (testing "Let it Be"
    (is (= 10 (let [x 7 y 3 _ 1] (+ x y))))
    (is (= 4 (let [_ 7 y 3 z 1] (+ y z))))
    (is (= 1 (let [_ 7 _ 3 z 1] z)))))


;;; Ex 037 -  Elementary.
;;  Regex patterns are supported with a special reader macro.

(def str37 "ABC")
(deftest test37
  (testing "Regular Expressions")
  (is (= str37 (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))))


;;; Ex 057 Elementary
;;  A recursive function is a function which calls itself. This is one of the
;;  fundamental techniques used in functional programming.

(def lst57 '(5 4 3 2 1))

(deftest test57
  (testing "Simple Recursion"
    (is (= lst57 ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5)))))


;;; Ex 068 - Elementary - recursion
;;  Clojure only has one non-stack-consuming looping construct: recur.
;;  Either a function or a loop can be used as the recursion point.
;;  Either way, recur rebinds the bindings of the recursion point to the values
;;  it is passed.
;;  Recur must be called from the tail-position, and calling it elsewhere will
;;  result in an error.

(def lst68 '(7 6 5 4 3))

(deftest test68
  (testing "Recurring Theme"
    (is (= lst68
           (loop [x 5
                  result []]
             (if (> x 0)
               (recur (dec x) (conj result (+ 2 x)))
               result))))))


;;; Ex 071 - Elementary
;;  The -> macro threads an expression x through a variable number of forms.
;;  First, x is inserted as the second item in the first form, making a list of
;;  it if it is not a list already.
;;  Then the first form is inserted as the second item in the second form,
;;  making a list of that form if necessary. This process continues for all the
;;  forms. Using -> can sometimes make your code more readable.

;; last
(deftest test71
  (testing "Rearranging Code: ->"
    (is (= (last (sort (rest (reverse [2 5 4 1 3 6]))))
           (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (last))
           5))))



;;; Ex 072 - Elementary
;; The ->> macro threads an expression x through a variable number of forms.
;; First, x is inserted as the last item in the first form, making a list of
;; it if it is not a list already. Then the first form is inserted as the last
;; item in the second form, making a list of that form if necessary.
;; This process continues for all the forms. Using ->> can sometimes make your
;; code more readable.

(deftest test72
  (testing "Rearranging Code: ->>"
    (is (= (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
           (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (reduce +))
           11))))


;;; Ex 145 - Elementary - core-functions - seqs
;;  Clojure's for macro is a tremendously versatile mechanism for producing a
;;  sequence based on some other sequence(s). It can take some time to
;;  understand how to use it properly, but that investment will be paid back
;;  with clear, concise sequence-wrangling later. With that in mind, read over
;;  these for expressions and try to see how each of them produces the same
;;  result.

(def lst145 '(1 5 9 13 17 21 25 29 33 37))
(deftest test 145
  (testing "For the win"
    (is (= lst145 (for [x (range 40)
                        :when (= 1 (rem x 4))]
                    x)))
    (is (= lst145 (for [x (iterate #(+ 4 %) 0)
                        :let [z (inc x)]
                        :while (< z 40)]
                    z)))
    (is (= lst145 (for [[x y] (partition 2 (range 20))]
                    (+ x y))))))