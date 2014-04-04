/*******************************************************************************
 * Copyright 2014 Katja Hahn
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.github.katjahahn.sections.rsrc

import Level._

/**
 * Represents the level of a {@link ResourceDirectoryTable}).
 * Windows usually has three levels, that are type, name and language.
 * 
 * @constructor creates an instance of the level with levelNr
 * @param levelNr the number of the level
 */
class Level(val levelNr: Int) extends Equals {

  override def toString(): String = 
    "level: " + levelDescription.getOrElse(levelNr, levelNr.toString)

  /**
   * Returns a level that is one level higher than the current.
   * 
   * @return a new level instance with it's levelNr incremented by one
   */
  def up(): Level = new Level(levelNr + 1)

  def canEqual(other: Any) = {
    other.isInstanceOf[Level]
  }

  override def equals(other: Any) = {
    other match {
      case that: Level => that.canEqual(Level.this) && levelNr == that.levelNr
      case _ => false
    }
  }

  override def hashCode() = {
    val prime = 41
    prime + levelNr.hashCode
  }

}

//TODO case class for type, name and language, calling super constructor? How?

object Level {
  
  private val levelDescription = Map(1 -> "type", 2 -> "name", 3 -> "language")

  def apply(): Level = new Level(1)
}
