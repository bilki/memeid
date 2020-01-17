/*
 * Copyright 2019-2020 47 Degrees, LLC. <http://www.47deg.com>
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
 */

package memeid.cats

import cats.effect.IO

import memeid.UUID
import memeid.cats.syntax._
import org.specs2.matcher.IOMatchers
import org.specs2.mutable.Specification

class SyntaxSpec extends Specification with IOMatchers {

  "v1 constructor" should {

    "create version 1 UUIDs" >> {
      UUID.v1[IO] must returnValue(anInstanceOf[UUID.V1])
    }

  }

  "v3 constructor" should {

    "create version 3 UUIDs" >> {
      UUID.v3[IO, String](UUID.V4.random, "hi") must returnValue(anInstanceOf[UUID.V3])
    }

  }

  "random constructor" should {

    "create version 4 UUIDs" >> {
      UUID.random[IO] must returnValue(anInstanceOf[UUID.V4])
    }

  }

  "squuid constructor" should {

    "create version 4 UUIDs" >> {
      UUID.squuid[IO] must returnValue(anInstanceOf[UUID.V4])
    }

  }

  "v5 constructor" should {

    "create version 5 UUIDs" >> {
      UUID.v5[IO, String](UUID.V4.random, "hi") must returnValue(anInstanceOf[UUID.V5])
    }

  }

}