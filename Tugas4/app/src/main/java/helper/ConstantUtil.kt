package helper

import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.ui.skill.Skills

object ConstantUtil {
    fun getSkillData(fragment: Fragment):ArrayList<Skills>{
        val skillList = ArrayList<Skills>()
        val skillTxt = fragment.resources.getStringArray(R.array.skills_array)
        val skillImg = fragment.resources.obtainTypedArray(R.array.skill_image_array)

        for (i in skillTxt.indices) {
            skillList.add(Skills(skillTxt[i], skillImg.getResourceId(i, 0)))
        }
        skillImg.recycle()
        return skillList
    }
}