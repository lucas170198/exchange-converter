(ns conversor.money-changer
  (:require [clj-http.client :as http-cliente]
            [config.core :refer [env]]
            [cheshire.core :refer [parse-string]]))

(def api-key (:api-key env))

(def api-url "https://free.currconv.com/api/v7/convert")

(defn padroniza-args [de para]
  (str de "_" para))

(defn obter-cotacao [de para]
  (let [moeda (padroniza-args de para)]
    (-> (:body (http-cliente/get api-url
                                 {:query-params {"q" moeda
                                   "apiKey" api-key}}))
        (parse-string)
        (get-in ["results" moeda "val"]))))