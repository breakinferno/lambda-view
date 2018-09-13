;; ESTree Spec
;; https://github.com/estree/estree

(ns lambda-view.javascript.expression.t-unary
  (:use [lambda-view.javascript.render :only [render-node]]
        [lambda-view.javascript.common :only [smart-box
                                              operator
                                              white-space-optional]]
        [lambda-view.tag :only [id-of]]
        [lambda-view.javascript.expression.utils :only [render-node-by-priority]]))

;; UnaryExpression
(defn render [node]
  (let [op (get node "operator")
        prefix (get node "prefix")                          ;TODO when will it be false?
        argument (get node "argument")]
    [:div.unary.expression
     (operator op)
     (white-space-optional)
     (render-node-by-priority node argument)]))

(def demo ["!a;"
           "+a;"
           "!a;"
           "~a;"
           "!a;"
           "typeof a;"
           "void a;"
           "delete a;"])