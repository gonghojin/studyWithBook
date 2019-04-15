import * as types from '../actions/ActionTypes';

const initialState = {
    counters: [
        {
            number: 0,
            color: 'black',
        }
    ],
};

const counter = (state = initialState, action) => {
    const { counters } = state;
    switch (action.type) {
        case types.CREATE:
            return {
                counters: [
                    ...counters,
                    {
                        number: 0,
                        color: action.color,
                    },
                ],
            };
        case types.REMOVE:
            return {
              counters: counters.slice(0, counters.length - 1),
            };
        case types.INCREEMNT:
            return {
                counters: [
                    ...counters.slice(0, action.index),
                    {
                        ...counters[action.index], // 기존 객체에
                        number: counters[action.index].number + 1, // 새 number 값 덮어쓰기
                    },
                    ...counters.slice(action.index + 1, counters.length) // 선택한 인덱스의 다음 아이템들
                ],
            };
        case types.DECREMENT:
            return {
                counters: [
                    ...counters.slice(0, action.index),
                    {
                        ...counters[action.index],
                        number: counters[action.index].number - 1,
                    },
                    ...counters.slice(action.index + 1, counters.length) // 선택한 인덱스의 다음 아이템들
                ],
            };
        case types.SET_COLOR:
            return {
                counters: [
                    ...counters.slice(0, action.index),
                    {
                        ...counters[action.index],
                        color: action.color,
                    },
                    ...counters.slice(action.index + 1, counters.length),
                ],
            };
        default:
            return state;
    }
};

export default counter;