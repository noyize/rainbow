package com.example.rainbow.playground

import android.graphics.drawable.Drawable

/** A list item for descriptor [DlsComponentAdapter] */
data class DlsComponentListItem(
  /** Name of the component */
  val name: String,

  /** Icon to represent the component in list */
  val icon: Drawable?,

  /** Type of the component. Useful for identifying list item and click events in a List. */
  val type: DlsComponentType,
)

/** A type of the component used to describe the list item in [DlsComponentAdapter] */
sealed class DlsComponentType {
  object TypographyComponent : DlsComponentType()
}
