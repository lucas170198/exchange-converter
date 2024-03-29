(ns conversor.handler-options
  (:require [clojure.tools.cli :refer [parse-opts]]))

(def opcoes-do-programa
  [["-d" "--de moeda base" "moeda base para conversao"
    :default "eur"]
   ["-p" "--para moeada destino"
    "moeda a qual queremos saber o valor"]])

(defn interpretar-opcoes [argumentos]
  (:options (parse-opts argumentos opcoes-do-programa)))