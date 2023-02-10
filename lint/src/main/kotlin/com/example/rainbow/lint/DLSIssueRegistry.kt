@file:Suppress("UnstableApiUsage")

package com.example.rainbow.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.Issue

class DLSIssueRegistry : IssueRegistry() {

  override val vendor = Vendor(vendorName = "rainbow", feedbackUrl = "")

  override val issues: List<Issue>
    get() = listOf()
}
