package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member findMember(Long MemberId) {
        return memberRepository.findById(MemberId);
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }
}
