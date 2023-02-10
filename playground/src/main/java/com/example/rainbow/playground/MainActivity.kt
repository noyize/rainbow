package com.example.rainbow.playground

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.rainbow.playground.DlsComponentType.TypographyComponent
import com.example.rainbow.playground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)
    val adapter = DlsComponentAdapter(this::onClickDlsComponentListItem)
    binding.dlsComponentList.adapter = adapter
    adapter.submitList(createDlsComponentList())
  }

  private fun createDlsComponentList(): List<DlsComponentListItem> {
    return mutableListOf(
      DlsComponentListItem(
        name = getString(R.string.typography_title),
        icon = ContextCompat.getDrawable(this, R.drawable.ic_typography),
        type = TypographyComponent,
      )
    )
  }

  private fun onClickDlsComponentListItem(listItem: DlsComponentListItem) {
    when (listItem.type) {
      TypographyComponent -> {
        Toast.makeText(this, "Typography screen", Toast.LENGTH_SHORT).show()
      }
    }
  }
}
