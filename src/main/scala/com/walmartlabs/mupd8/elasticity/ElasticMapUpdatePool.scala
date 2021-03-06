/**
 * Copyright 2011-2012 @WalmartLabs, a division of Wal-Mart Stores, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.walmartlabs.mupd8.elasticity

import java.util.ArrayList
import scala.collection.mutable.Queue
import scala.concurrent.Lock
import java.util.concurrent.atomic.AtomicInteger
import scala.collection.parallel.mutable.ParArray
import com.walmartlabs.mupd8.HashRing
import com.walmartlabs.mupd8.MapUpdatePool
import com.walmartlabs.mupd8.MUCluster
import com.walmartlabs.mupd8.AppRuntime
import com.walmartlabs.mupd8.MapUpdateClass

class ElasticMapUpdatePool[T <: MapUpdateClass[T]](val appRuntime: AppRuntime, override val poolsize: Int, override val ring: HashRing, clusterFactory: (T => Unit) => MUCluster[T])
  extends MapUpdatePool[T](poolsize, ring, clusterFactory) {

  var loadRedistributionActivityInProgress = false
  var hashRingTransformationDone = false;
  var oracle: ElasticOracle = null

  def getDestinationLoadRecevingHost(key: Any) = {
    oracle.getLoadReceiverHostIndex()
  }

  def notifyLoadRedistributionBegin(oracle: ElasticOracle) = synchronized {
    this.oracle = oracle
    loadRedistributionActivityInProgress = true
    hashRingTransformationDone = false
  }

  def getAppRuntime(): AppRuntime = {
    appRuntime
  }
}
