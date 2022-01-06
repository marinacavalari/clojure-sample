(ns clojure-sample.core
  (:require [databricks-sdk.core :as sdk]))

(comment
  (sdk/create-cluster! {:token (System/getenv "DATABRICKS_STAGING_TOKEN")
                       :timeout 30000
                       :host (System/getenv "DATABRICKS_STAGING_HOST")
                       :body {:cluster_name "my-cluster"
                              :spark_version "7.3.x-scala2.12"
                              :node_type_id "i3.xlarge"
                              :spark_conf {:spark.speculation true}
                              :aws_attributes {:availability "SPOT"
                                               :zone_id  "us-west-2a"}
                              :num_workers 25}})
  
  (sdk/list-clusters {:token (System/getenv "DATABRICKS_STAGING_TOKEN")
                      :timeout 30000
                      :host (System/getenv "DATABRICKS_STAGING_HOST")
                      :body {}})
  
  (sdk/terminate-cluster! {:token (System/getenv "DATABRICKS_STAGING_TOKEN")
                      :timeout 30000
                      :host (System/getenv "DATABRICKS_STAGING_HOST")
                      :body {:cluster_id "1001-200146-blimp4"}})
  
  (sdk/start-cluster! {:token (System/getenv "DATABRICKS_STAGING_TOKEN")
                           :timeout 30000
                           :host (System/getenv "DATABRICKS_STAGING_HOST")
                           :body {:cluster_id "1001-200146-blimp4"}}))
