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

class Fragment5 : Fragment() {

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
        profileList.add(Profile(1, "2023 BDIA 잡페어"))
        profileList.add(Profile(2, "[도서관] IEEE Authorship Seminar 개최 안내"))
        profileList.add(Profile(3, "핵심역량도서관 개관 안내"))
        profileList.add(Profile(4, "2023학년도 대학생활 설계 박람회 개최 안내"))
        profileList.add(Profile(5, "[교수학습지원센터] 2023학년도 10월 학습법 특강 실시 안내"))
        profileList.add(Profile(6, "「2023 부산 사이버 보안 콘퍼런스」 행사 참석 안내"))
        profileList.add(Profile(7, "[2023 벤처스타트업 SW개발인재 매칭페스티벌]"))
        profileList.add(Profile(8, "표준현장실습 관련 희망기업 설문조사 참여 안내(~11/10)"))
        profileList.add(Profile(9, "[도서관] 10월 리포트 작성 온라인 교육 안내"))
        profileList.add(Profile(10, "2023년 부경대학교 학생설계전공 공모전 연장 안내"))
        profileList.add(Profile(11, "2023학년도 저학년 직무경험「진로부트캠프 2차」모집"))
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