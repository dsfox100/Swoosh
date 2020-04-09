package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Package.EXTRA_LEAGUE
import com.example.swoosh.Package.EXTRA_SKILL
import com.example.swoosh.R
import kotlinx.android.synthetic.main.activity_skill.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)
    }

    fun onBeginnerClick(view: View) {
        ballerSkillBtn.isChecked = false
        skill = "beginner"
    }

    fun onBallerClick(view: View) {
        beginnerSkillBtn.isChecked = false
        skill = "baller"

    }

    fun onSkillFinishClicked(view: View) {
        if (skill != "") {
            val FinishActivity = Intent(this, FinishActivity::class.java)
            FinishActivity.putExtra(EXTRA_SKILL, skill)
            FinishActivity.putExtra(EXTRA_LEAGUE, league)
            startActivity(FinishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }
}

