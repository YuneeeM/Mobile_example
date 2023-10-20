package com.cookandroid.schoolapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Fragment4 : Fragment() {

    private lateinit var rv: RecyclerView

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_4, container, false)

        rv = view.findViewById(R.id.rv)

        val profileList = ArrayList<Profile>()
        profileList.add(Profile(1, "어프로티움㈜ 채용 전제형 동계 인턴십 설명회"))
        profileList.add(Profile(2, "[한화정밀기계] 2023 하반기 신입사원 채용 (~11/5)"))
        profileList.add(Profile(3, "[NH농협손해보험] 2023 농협손해보험 신규직원 채용(5급) | ~10.27"))
        profileList.add(Profile(4, "[NH농협은행] 23년 하반기 5급 신규직원 채용 (~10/27)"))
        profileList.add(Profile(5, "[DN솔루션즈] 2023 DN솔루션즈 채용연계형 인턴사원 공개채용 (~10/30)"))
        profileList.add(Profile(6, "펄어비스 채용연계형 겨울 인턴십"))
        profileList.add(Profile(7, "[2023 벤처스타트업 SW개발인재 매칭페스티벌]"))
        profileList.add(Profile(8, "2023년 하반기 KB손해보험 4급 채용연계형 인턴모집"))
        profileList.add(Profile(9, "현대위아 대졸 신입사원 모집"))
        profileList.add(Profile(10, "2023년 하반기 KB손해보험 4급 채용연계형 인턴모집"))
        profileList.add(Profile(11, "마감임박! 포스코이앤씨 '23 하 신입사원 채용(~10.16 월 12시)？？"))
        profileList.add(Profile(12, "2023년 하반기 고려아연 및 계열사 신입사원 공개채용"))
        profileList.add(Profile(13, "마감임박! 포스코이앤씨 '23 하 신입사원 채용(~10.16 월 12시)？？"))
        profileList.add(Profile(14, "2024년도 애경그룹 신입사원 공개채용"))
        profileList.add(Profile(15, "[NH투자증권] 2023 하반기 대졸 신입사원 채용 (~10/15)"))
        profileList.add(Profile(16, "[계룡건설] 2023 하반기 신입사원 채용 모집"))
        profileList.add(Profile(17, "[신세계아이앤씨] SW 인재 양성 교육 홍표 협조 요청의 건"))
        profileList.add(Profile(18, "[한화솔루션] 2023 한화솔루션 인사이트부문 신입사원 채용 (~10/20)"))

        rv.adapter = CustomAdapter(profileList)
        rv.layoutManager = LinearLayoutManager(requireContext())


        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}